import { Component, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HotelListComponent } from './components/hotel-list/hotel-list.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes, Route } from '@angular/router';
import { HoteFormComponent } from './components/hotel-form/hotel-form.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegistrationformComponent } from './components/registrationform/registrationform.component';
import { UsersettingComponent } from './components/usersetting/usersetting.component';
import { HotelsettingComponent } from './components/hotelsetting/hotelsetting.component';
import { HotelbookComponent } from './components/hotelbook/hotelbook.component';
import { BookingSuccessComponent } from './components/booking-success/booking-success.component';
import { TransportComponent } from './components/transport/transport.component';

const routes:Routes=[{path:'',component:WelcomeComponent},
{path:'users',component:UserListComponent},{path:'userform',component:UserFormComponent},
{path : 'updateuser/:user_id',component:UserFormComponent},
{path:'hotels',component:HotelListComponent},
{path:'hotelform',component:HoteFormComponent},
{path : 'updatehotel/:hotel_id',component:HoteFormComponent},
{path:'home', component:HomeComponent},
{path:'login',component:LoginComponent},
{path:'registraionform',component:RegistrationformComponent},
{path:'hoteldetails',component:HotelsettingComponent},
{path:'bookhotel',component:HotelbookComponent},
{path:'booking-success', component:BookingSuccessComponent},
{path:'trans',component:TransportComponent}]
@NgModule({
  declarations: [
    AppComponent,
    HotelListComponent,
    UserListComponent,
    UserFormComponent,
    WelcomeComponent,
    HoteFormComponent,
    HomeComponent,
    LoginComponent,
    RegistrationformComponent,
    UsersettingComponent,
    HotelsettingComponent,
    HotelbookComponent,
    BookingSuccessComponent,
    TransportComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule,
    ReactiveFormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
