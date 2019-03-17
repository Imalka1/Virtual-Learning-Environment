import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {StudentSummaryComponent} from './views/student-reg/student-summary/student-summary.component';
import {StudentSettingsComponent} from './views/student-reg/student-settings/student-settings.component';
import {StudentRegistrationsComponent} from './views/student-reg/student-registrations/student-registrations.component';
import {StudentDetailsComponent} from './views/student-reg/student-details/student-details.component';
import {SemesterRegistrationComponent} from './views/student-reg/semester-registration/semester-registration.component';
import {SemesterPaymentsComponent} from './views/student-reg/semester-payments/semester-payments.component';
import {MainComponent} from './views/main/main.component';
import {PasswordResetComponent} from './views/login-screen/password-reset/password-reset.component';
import {LoginComponent} from './views/login-screen/login/login.component';
import {LockComponent} from './views/login-screen/lock/lock.component';
import {EmailVerifyComponent} from './views/login-screen/email-verify/email-verify.component';
import {LecturerDetailsComponent} from './views/lecturer-subjects-registrations/lecturer-details/lecturer-details.component';
import {SubjectsDetailsComponent} from './views/lecturer-subjects-registrations/subjects-details/subjects-details.component';
import {LecturerSubjectsRegistrationsComponent} from './views/lecturer-subjects-registrations/lecturer-subjects-registrations.component';
import {StudentRegComponent} from './views/student-reg/student-reg.component';
import {DashboardComponent} from './views/dashboard/dashboard.component';
import {EventsCalendarComponent} from './views/dashboard/events-calendar/events-calendar.component';
import {ChatRoomComponent} from './views/chat-room/chat-room.component';
import {AppRoutingModule} from "./app-routing.module";
import {HttpClientModule} from "@angular/common/http";
import {LoginScreenComponent} from './views/login-screen/login-screen.component';
import {LoginGuard} from "./views/login-screen/login/login.guard";
import {LoginScreenGuard} from "./views/login-screen/login-screen.guard";
import {PasswordResetGuard} from "./views/login-screen/password-reset/password-reset.guard";
import {DatePipe} from "@angular/common";
import {LockGuard} from "./views/login-screen/lock/lock.guard";
import {FormsModule} from "@angular/forms";
import {WizardColorService} from "./services/common/wizard-color/wizard-color.service";
import {LoginService} from "./services/login-screen/login/login.service";
import {StudentDetailsService} from "./services/student-reg/student-details/student-details.service";
import {StudentRegistrationService} from "./services/student-reg/student-registration/student-registration.service";
import {FileService} from "./services/common/file/file.service";
import {DegreeService} from "./services/common/degree/degree.service";
import {FacultyService} from "./services/common/faculty/faculty.service";
import {IntakeService} from "./services/common/intake/intake.service";
import {SocketService} from "./services/common/socket/socket.service";
import {RootComponent} from './views/root/root.component';
import {NgxPaginationModule} from 'ngx-pagination';
import {CookieService} from 'ngx-cookie-service';
import { SubjectsComponent } from './views/course-work/subjects/subjects.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentSummaryComponent,
    StudentSettingsComponent,
    StudentRegistrationsComponent,
    StudentDetailsComponent,
    SemesterRegistrationComponent,
    SemesterPaymentsComponent,
    MainComponent,
    PasswordResetComponent,
    LoginComponent,
    LockComponent,
    EmailVerifyComponent,
    LecturerDetailsComponent,
    SubjectsDetailsComponent,
    LecturerSubjectsRegistrationsComponent,
    StudentRegComponent,
    DashboardComponent,
    EventsCalendarComponent,
    ChatRoomComponent,
    LoginScreenComponent,
    RootComponent,
    SubjectsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    NgxPaginationModule
  ],
  providers: [
    StudentDetailsService,
    StudentRegistrationService,
    LoginService,
    FacultyService,
    IntakeService,
    DegreeService,
    FileService,
    WizardColorService,
    SocketService,
    CookieService,
    LoginGuard,
    LoginScreenGuard,
    LockGuard,
    PasswordResetGuard,
    DatePipe,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
