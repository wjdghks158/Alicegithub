import { Component, OnInit } from '@angular/core';
import { ToastComponent } from '../shared/toast/toast.component';
import { MatchService } from '../shared/services/match.service';
import { RecommendService } from '../shared/services/recommend.service';
import { AuthService } from '../shared/services';
import { OrderPipe } from 'ngx-order-pipe';
import { UserService } from '../shared/services/user.service';
import { ContestService } from '../shared/services/contest.service';

  

  //this.getMatchs();


@Component({
  selector: 'app-board-recommend',
  templateUrl: './board-recommend.component.html',
  styleUrls: ['./board-recommend.component.scss']
})
export class BoardRecommendComponent implements OnInit {
recommendMatchs = [];
contests = [];
matchs = [];
resultmatchs = [];
match = {};
isLoading = true;

users = [];
recommendContests = [];

//Pipe
order: string = 'created_at';
reverse: boolean = true;

//page 넘버링 할 때 쓰는 변수
p:number = 1;
total: number;
  constructor(public toast: ToastComponent,
    private matchService: MatchService,
    public auth: AuthService,
    private orderPipe: OrderPipe,
    private recommendService: RecommendService,
    private userService: UserService,
    private contestService: ContestService) {


     }
//나의 프로필 정보상태야
// 매칭글 다 끌고와
// 비교해 -- 유사도 점수 주고 제일 높은 한놈 가져와
// 보여줘

  ngOnInit() {
    //최종으로 contests, matchs에 보여줄 것 담는다.
    this.getUsers();
    this.getMatchs();

  }

  //recommendContests 추천 공모전 나왔으면 각각 contestid 값으로 find 하여 담아야죠~

  
  getContest() {
    var sortingField = "hits";
    this.recommendContests.sort(function(a, b) { // 내림차순
      return b[sortingField] - a[sortingField];
  });
  console.log(this.auth.currentUser);

    console.log(this.recommendContests);
    
  if(this.recommendContests.length <5) {
    for (var i=0; i<this.recommendContests.length; i++) {
      //console.log(this.recommendContests[i].contestid);
      this.contestService.getContest(this.recommendContests[i].contestid).subscribe(
        data => this.contests.push(data),
        error => console.log(error),
        () => {
          //console.log(this.contests);
          this.isLoading = false;
        }
      );
    }
  }
  else {
    for (var i=0; i<4; i++) {
      //console.log(this.recommendContests[i].contestid);
      this.contestService.getContest(this.recommendContests[i].contestid).subscribe(
        data => this.contests.push(data),
        error => console.log(error),
        () => {
          //console.log(this.contests);
          this.isLoading = false;
        }
      );
    }
  }


  }

  getMatch() {
    var sortingField = "score";
    this.recommendMatchs.sort(function(a, b) { // 내림차순
      return b[sortingField] - a[sortingField];
  });
  console.log(this.recommendMatchs);


    for (var i=0; i<this.recommendMatchs.length; i++) {
      //console.log(this.recommendContests[i].contestid);
      this.matchService.getMatch(this.recommendMatchs[i].matchid).subscribe(
        data => this.resultmatchs.push(data),
        error => console.log(error),
        () => {
          //console.log(this.contests);
          this.isLoading = false;
        }
      );
    }
}


  getMatch1(id) {
    this.matchService.getMatch(id).subscribe(
      data => this.match = data,
      error => console.log(error),
      () => {
        //console.log(this.match);
        this.isLoading = false;
        //console.log(this.match);
      }
    );
  }
  //매치글 다들고오나?
  getMatchs() {
    this.matchService.getMatchs().subscribe(
      data => this.matchs = data,
      error => console.log(error),
      () => {
        this.isLoading = false;
        //console.log(Object.keys(this.matchs).length);
        this.recommendMatch();  // 여기서 recommendMatch 하고 넘기자.
        this.getMatch();
      }
    );
  }


  getUsers() {
    this.userService.getUsers().subscribe(
      data => this.users = data,
      error => console.log(error),
      () => {//console.log("asdasdasdasd박정환");
       //console.log(this.users);
       //console.log(this.users.length);
       this.recommeandToUser();
       this.getContest();
        this.isLoading = false;}
    );
  }

  //유저 기반으로 조회한 공모전의 리스트 뽑아서 recommendContests에 저장함
  recommeandToUser() {
    var contestid;
    for ( var i =0; i<this.users.length; i++) {
      
      if(this.auth.currentUser._id  != this.users[i]._id){
       
        if(this.auth.currentUser.major  == this.users[i].major) { //이 조건 까지 부합해야 시작 할 수 있음
          //page 갯수가 5개 이상이면 5개만 5개 미만이면 내식 대로
          if(this.users[i].pages.length>= 5) {

            for (var k =1; k<6; k++ ) {
              //이미 있는 페이징이면 1 추가 하고 아니면 그냥 요소 추가함.
              contestid =this.users[i].pages[(this.users[i].pages.length)-k];
              var flag = false;
              for ( var s=0; s<this.recommendContests.length; s++) {
                if (this.recommendContests[s].contestid == contestid) {
                  this.recommendContests[s].hits += 1;
                  flag = true;
                  break;
                }
              }
              //flag가 false 라면 기존에 없던 contestid이므로 직접 추가한다.
              if(!flag) {
                this.recommendContests.push({contestid: contestid, hits: 1});
              }
             }
          }else if(this.users[i].pages.length>1 && this.users[i].pages.length<5) {
            for(var j=0; j< this.users[i].pages.length; j++) {
              contestid =this.users[i].pages[(this.users[i].pages.length)-1-j];
              for ( var s=0; s<this.recommendContests.length; s++) {
                if (this.recommendContests[s].contestid == contestid) {
                  this.recommendContests[s].hits += 1;
                  flag = true;
                  break;
                }
              }
              //flag가 false 라면 기존에 없던 contestid이므로 직접 추가한다.
              if(!flag) {
                this.recommendContests.push({contestid: contestid, hits: 1});
              }
            }
          }
          

          //console.log(this.recommendContests[0].contestid);
         // this.recommendContests.sort();
         // console.log(this.recommendContests);
        }
      }
    }
 //console.log("찍어보자");
 //this.getContest();
// console.log(this.recommendContests);

 //recommendContests 담긴 것 갯수 새어서 가장 많이 채택된 5개 보여준다.
    //this.auth.currentUser.major 
    //어떤 유저 정보 모을 것인지 테스트한다. 나는 it 선택한다.
    //유저가 가장 최근에 조회한 것들 추천 contestid 값에 넣는다.
    // 다 넣으면 후에 contest 조회 때린다. 
  }
  recommendMatch() {
    for (var i=0; i<this.matchs.length; i++) {
      var score = 0;

      if(!this.matchs[i].matchstate) { //매칭 완료된 상태가 아니라면 조사 한다.
        if(this.auth.currentUser.education== this.matchs[i].education || this.auth.currentUser.major== this.matchs[i].major) {
          //둘다 같아 2점
          //하나만 같은데 education 이면 1점
          //하나만 같은데 major 이면 0.5점
          //둘다 아니면 점수 안줌
          
          if(this.auth.currentUser.education== this.matchs[i].education && this.auth.currentUser.major== this.matchs[i].major) {
            score +=2;
          }
          else if(this.auth.currentUser.education== this.matchs[i].education) {
            score +=1;
          }
          else if(this.auth.currentUser.major== this.matchs[i].major) {
            score +=0.5;
          }
          if(score >= 0.5) {
            this.recommendMatchs.push({matchid: this.matchs[i]._id, score: score});
          }
        }
      }    
    } 
  }

  setOrder(value: string){
    if(this.order === value){
      this.reverse = !this.reverse;
    }

    this.order = value;
  }

}