import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { combineLatest } from 'rxjs';
import {HomeComponent} from '../app/component/home/home.component'
import { AboutComponent } from './component/about/about.component';
import { AdminLoginComponent } from './component/admin-login/admin-login.component';
import { ContactUsComponent } from './component/contact-us/contact-us.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { LoginComponent } from './component/login/login.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { ServiceComponent } from './component/service/service.component';
import { SploginComponent } from './component/splogin/splogin.component';
import { AllServiceProviderComponent } from './components/all-service-provider/all-service-provider.component';
import { AllServicesComponent } from './components/all-services/all-services.component';
import { AllUserComponent } from './components/all-user/all-user.component';
import { FeedbackComponent } from './components/feedback/feedback.component';
import { ProviderUpdateComponent } from './components/provider-update/provider-update.component';
import { SpNotificationComponent } from './components/sp-notification/sp-notification.component';
import { SpRegisterComponent } from './components/sp-register/sp-register.component';
import { SpServiceByIdComponent } from './components/sp-service-by-id/sp-service-by-id.component';
import { UpdateUserComponent } from './components/update-user/update-user.component';
import { UserDashComponent } from './components/user-dash/user-dash.component';
import { UserRegistrationComponent } from './components/user-registration/user-registration.component';
import { UserViewComponent } from './components/user-view/user-view.component';
import { ViewComponent } from './components/view/view.component';
import { DriverComponent } from './components/Workers/driver/driver.component';
import { ElectricianComponent } from './components/Workers/electrician/electrician.component';
import { GardenerComponent } from './components/Workers/gardener/gardener.component';
import { MaidComponent } from './components/Workers/maid/maid.component';
import { PainterComponent } from './components/Workers/painter/painter.component';
import { PlumberComponent } from './components/Workers/plumber/plumber.component';
import { AdminGuard } from './Guard/admin.guard';
import { AllGuardGuard } from './Guard/all-guard.guard';
import { AuthGuard } from './Guard/auth.guard';
import { LoginGuard } from './Guard/login.guard';
import { SpAdminGuard } from './Guard/sp-admin.guard';
import { SpGuardGuard } from './Guard/sp-guard.guard';
import { UAGuardGuard } from './Guard/uaguard.guard';
import { UserGuard } from './Guard/user.guard';
const routes: Routes = [
  {
    path:"",
    component:HomeComponent,
    pathMatch:"full"
  },
  {
    path:"login",
    component:LoginComponent,
    pathMatch:"full",
    canActivate:[LoginGuard]
  },
  {
    path:"dashboard",
    component:DashboardComponent,
    pathMatch:"full",
    canActivate:[AuthGuard]
  },
  {
    path:"service",
    component:ServiceComponent
  },
  {
    path:"service/gardener",
    component:GardenerComponent,
    canActivate:[AuthGuard]
  },
  {
    path:"service/painter",
    component:PainterComponent,
    pathMatch:"full",
    canActivate:[AuthGuard]
  },
  {
    path:"service/driver",
    component:DriverComponent,
    pathMatch:"full",
    canActivate:[AuthGuard]
  },
  {
    path:"service/electrician",
    component:ElectricianComponent,
    pathMatch:"full",
    canActivate:[AuthGuard]
  },
  {
    path:"service/maid",
    component:MaidComponent,
    pathMatch:"full",
    canActivate:[AuthGuard]
  },
  {
    path:"service/plumber",
    component:PlumberComponent,
    pathMatch:"full",
    canActivate:[AuthGuard]
  },
  {
    path:"service/view",
    component:ViewComponent,
    pathMatch:"full",
    canActivate:[AllGuardGuard]

  },
  {
    path:"user/register",
    component:UserRegistrationComponent,
    pathMatch:"full",
    canActivate:[LoginGuard]
  },
  {
    path:"serviprovider/register",
    component:SpRegisterComponent,
    pathMatch:"full",
    canActivate:[LoginGuard]
  },
  {
    path:"serviprovider/spNotify",
    component:SpNotificationComponent,
    pathMatch:"full",
    canActivate:[SpGuardGuard]

  },
  {
    path:"view/service",
    component:UserViewComponent,
    pathMatch:"full",
    canActivate:[UserGuard]
  },
  {
    path:"service/feedback",
    component:FeedbackComponent,
    pathMatch:"full",
    canActivate:[UserGuard] 
  },
  {
    path:"spLogin",
    component:SploginComponent,
    pathMatch:"full",
    canActivate:[LoginGuard]

  },
  {
    path:"adminLogin",
    component:AdminLoginComponent,
    pathMatch:"full",
    canActivate:[LoginGuard]

  },
  {
    path:"AllUser",
    component:AllUserComponent,
    pathMatch:"full",
    canActivate:[AdminGuard]
  },
  {
    path:"AllServiceProvider",
    component:AllServiceProviderComponent,
    pathMatch:"full",
    canActivate:[AdminGuard]

  },
  {
    path:"AllServices",  
    component:AllServicesComponent,
    pathMatch:"full",
    canActivate:[AdminGuard]

  },
  {
    path:'nav',
    component:NavbarComponent,
    pathMatch:"full",
  },
  {
    path:'userProfile',
    component:UserDashComponent,
    pathMatch:"full",
    canActivate:[UserGuard]
  },
  {
    path:'viewServiceById',
    component:SpServiceByIdComponent,
    pathMatch:"full",
    canActivate:[SpGuardGuard]
  },
  {
    path:'about',
    component:AboutComponent,
    pathMatch:"full",
  },
  {
    path:'contact',
    component:ContactUsComponent,
    pathMatch:"full",
  },
  {
    path:'userUpdate',
    component:UpdateUserComponent,
    pathMatch:"full",
    canActivate:[UserGuard]
  },
  {
    path:'providerUpdate',
    component:ProviderUpdateComponent,
    pathMatch:"full",
    canActivate:[UserGuard]
  }

  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
