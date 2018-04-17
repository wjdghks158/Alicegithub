import 'rxjs/add/operator/filter';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/mergeMap';

import { Component, OnInit } from '@angular/core';
import { AuthService, AppGlobals } from './shared/services';
import { Router, NavigationEnd, ActivatedRoute } from '@angular/router';
import { MessageService } from './shared/services/message.service';






@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  receiveMessages = [];
  isLoading = true;

  // role: 'guest';
  constructor(public auth: AuthService, private appGlobals: AppGlobals, private router: Router,
    private activatedRoute: ActivatedRoute,
    private messageService :MessageService) { }

  ngOnInit() {
    this.router.events
      .filter((event) => event instanceof NavigationEnd)
      .map(() => this.activatedRoute)
      .map((route) => {
        while (route.firstChild) {
          route = route.firstChild;
        }
        return route;
      })
      .filter((route) => route.outlet === 'primary')
      .mergeMap((route) => route.data)
      .subscribe((event) => {
        // this.role = this.appGlobals.userInfo.role;
      });
    // this.role = 'guest';


    this.getReceiveMessage();

  }

  getReceiveMessage() {
    var url ='/api/searchmessages';
    var receiver = "receiver";
    this.messageService.search(url+"?"+receiver+"="+this.auth.currentUser.username).subscribe(
      data => {
        console.log(data);
        for( var i=0; i<data.length; i++) {
          if(data[i].code == "1") { //수신함
            if(data[i].read_at == null) {  
              console.log("test" + data.length);
              this.receiveMessages.push(data[i]);
              console.log(this.receiveMessages[0].title);
            }
          }
        }
       // this.messages = data
      },
      error => console.log(error),
      () => {
        this.isLoading = false;
        console.log(Object.keys(this.receiveMessages).length);
        console.log(this.receiveMessages);
      }
    );
  }


}
