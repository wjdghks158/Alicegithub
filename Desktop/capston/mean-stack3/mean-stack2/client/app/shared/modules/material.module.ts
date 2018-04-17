import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  MatButtonModule, MatToolbarModule, MatProgressSpinnerModule,
  MatCardModule, MatFormFieldModule, MatCheckboxModule, MatTableModule,
  MatDatepickerModule, MatInputModule, MatSelectModule, MatNativeDateModule,
  MatIconModule, MatSidenavModule, MatSliderModule, MatExpansionModule
} from '@angular/material';
import {MatListModule} from '@angular/material/list';

@NgModule({
  imports: [
    CommonModule,
    MatButtonModule,
    MatToolbarModule,
    MatProgressSpinnerModule,
    MatCardModule,
    MatFormFieldModule,
    MatCheckboxModule,
    MatTableModule,
    MatDatepickerModule,
    MatInputModule,
    MatSelectModule,
    MatNativeDateModule,
    MatIconModule,
    MatSidenavModule,
    MatSliderModule,
    MatExpansionModule,
    MatListModule
  ],
  exports: [
    MatButtonModule,
    MatToolbarModule,
    MatProgressSpinnerModule,
    MatCardModule,
    MatFormFieldModule,
    MatCheckboxModule,
    MatTableModule,
    MatDatepickerModule,
    MatInputModule,
    MatSelectModule,
    MatNativeDateModule,
    MatIconModule,
    MatSidenavModule
  ],
  declarations: []
})
export class MaterialModule { }
