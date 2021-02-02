import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MatToolbarModule} from '@angular/material/toolbar';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './component/navbar/navbar.component';
import { LoginComponent } from './component/login/login.component';
import { HomeComponent } from './component/home/home.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule} from '@angular/material/button';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule } from '@angular/forms'
import {MatInputModule} from '@angular/material/input';
import { HttpClientModule } from '@angular/common/http';
import { PainterComponent } from './components/Workers/painter/painter.component';
import { MaidComponent } from './components/Workers/maid/maid.component';
import { PlumberComponent } from './components/Workers/plumber/plumber.component';
import { GardenerComponent } from './components/Workers/gardener/gardener.component';
import { DriverComponent } from './components/Workers/driver/driver.component';
import { ElectricianComponent } from './components/Workers/electrician/electrician.component';
import { ServiceComponent } from './component/service/service.component';
import { ViewComponent } from './components/view/view.component';
import { UserRegistrationComponent } from './components/user-registration/user-registration.component';
import { SpRegisterComponent } from './components/sp-register/sp-register.component';
import { SpNotificationComponent } from './components/sp-notification/sp-notification.component';
import { UserViewComponent } from './components/user-view/user-view.component';
import { FeedbackComponent } from './components/feedback/feedback.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SploginComponent } from './component/splogin/splogin.component';
import { AdminLoginComponent } from './component/admin-login/admin-login.component';
import {AuthGuard} from './Guard/auth.guard'
import { LoginGuard } from './Guard/login.guard';
import { SpGuardGuard } from './Guard/sp-guard.guard';
import { UserGuard } from './Guard/user.guard';
import { UAGuardGuard } from './Guard/uaguard.guard';
import { AllUserComponent } from './components/all-user/all-user.component';
import { AllServiceProviderComponent } from './components/all-service-provider/all-service-provider.component';
import { AllServicesComponent } from './components/all-services/all-services.component';
import { AdminGuard } from './Guard/admin.guard';
import { UserDashComponent } from './components/user-dash/user-dash.component';
import { AboutComponent } from './component/about/about.component';
import { AllFeedbackComponent } from './components/all-feedback/all-feedback.component';
import { AllGuardGuard } from './Guard/all-guard.guard';
import { SpServiceByIdComponent } from './components/sp-service-by-id/sp-service-by-id.component';
import { SpAdminGuard } from './Guard/sp-admin.guard';
import { UpdateUserComponent } from './components/update-user/update-user.component';
import { ContactUsComponent } from './component/contact-us/contact-us.component';
import { ProviderUpdateComponent } from './components/provider-update/provider-update.component';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    HomeComponent,
    DashboardComponent,
    PainterComponent,
    MaidComponent,
    PlumberComponent,
    GardenerComponent,
    DriverComponent,
    ElectricianComponent,
    ServiceComponent,
    ViewComponent,
    UserRegistrationComponent,
    SpRegisterComponent,
    SpNotificationComponent,
    UserViewComponent,
    FeedbackComponent,
    SploginComponent,
    AdminLoginComponent,
    AllUserComponent,
    AllServiceProviderComponent,
    AllServicesComponent,
    UserDashComponent,
    AboutComponent,
    AllFeedbackComponent,
    SpServiceByIdComponent,
    UpdateUserComponent,
    ContactUsComponent,
    ProviderUpdateComponent,
    UserViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    MatCardModule,
    MatIconModule,
    MatMenuModule,
    FormsModule,
    MatInputModule,
    HttpClientModule,
    NgbModule
  ],
  exports: [
    MatButtonModule,
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
  ],
  providers: [AuthGuard ,LoginGuard ,SpGuardGuard ,UserGuard ,UAGuardGuard ,AdminGuard ,AllGuardGuard ,SpAdminGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
