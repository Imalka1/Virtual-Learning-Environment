import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {MainComponent} from "./views/main/main.component";
import {DashboardComponent} from "./views/dashboard/dashboard.component";
import {StudentRegComponent} from "./views/student-reg/student-reg.component";
import {StudentDetailsComponent} from "./views/student-reg/student-details/student-details.component";
import {StudentRegistrationsComponent} from "./views/student-reg/student-registrations/student-registrations.component";
import {SemesterPaymentsComponent} from "./views/student-reg/semester-payments/semester-payments.component";
import {SemesterRegistrationComponent} from "./views/student-reg/semester-registration/semester-registration.component";
import {StudentSummaryComponent} from "./views/student-reg/student-summary/student-summary.component";
import {LecturerSubjectsRegistrationsComponent} from "./views/lecturer-subjects-registrations/lecturer-subjects-registrations.component";
import {LecturerDetailsComponent} from "./views/lecturer-subjects-registrations/lecturer-details/lecturer-details.component";
import {SubjectsDetailsComponent} from "./views/lecturer-subjects-registrations/subjects-details/subjects-details.component";
import {LoginComponent} from "./views/login-screen/login/login.component";
import {LockComponent} from "./views/login-screen/lock/lock.component";
import {EmailVerifyComponent} from "./views/login-screen/email-verify/email-verify.component";
import {PasswordResetComponent} from "./views/login-screen/password-reset/password-reset.component";
import {LoginScreenComponent} from "./views/login-screen/login-screen.component";
import {LoginGuard} from "./views/login-screen/login/login.guard";
import {LoginScreenGuard} from "./views/login-screen/login-screen.guard";
import {LockGuard} from "./views/login-screen/lock/lock.guard";
import {PasswordResetGuard} from "./views/login-screen/password-reset/password-reset.guard";
import {RootComponent} from "./views/root/root.component";
import {SubjectsComponent} from "./views/course-work/subjects/subjects.component";

const appRoutes: Routes = [
  {
    path: "root", component: RootComponent,
    children: [
      {path: "dashboard", component: DashboardComponent},
      {
        path: "main", component: MainComponent,
        children: [
          {
            path: "student-reg", component: StudentRegComponent,
            children: [
              {path: "student-details", component: StudentDetailsComponent},
              {path: "student-registrations", component: StudentRegistrationsComponent},
              {path: "semester-registrations", component: SemesterRegistrationComponent, canActivate: [LoginGuard]},
              {path: "semester-payments", component: SemesterPaymentsComponent},
              {path: "student-payments", component: SemesterPaymentsComponent},
              {path: "student-summary", component: StudentSummaryComponent},
            ]
          },
          {
            path: "subjects", component: SubjectsComponent, canActivate: [LoginGuard]
          },
          {
            path: "lecturers-subjects", component: LecturerSubjectsRegistrationsComponent, canActivate: [LoginGuard],
            children: [
              {path: "lecturer-details", component: LecturerDetailsComponent},
              {path: "subject-details", component: SubjectsDetailsComponent},
            ]
          },
        ]
      },
      {
        path: "log-screen", component: LoginScreenComponent,
        children: [
          {path: "login", component: LoginComponent, canActivate: [LoginScreenGuard]},
          {path: "lock", component: LockComponent, canActivate: [LockGuard]},
          {path: "email-verify", component: EmailVerifyComponent},
          {path: "password-reset", component: PasswordResetComponent, canActivate: [PasswordResetGuard]}
        ]
      },
    ]
  },
  {path: "", pathMatch: "full", redirectTo: "/root/dashboard"},
  {path: "root", pathMatch: "full", redirectTo: "/root/dashboard"}
]

@NgModule({
  imports: [
    // CommonModule,
    RouterModule.forRoot(appRoutes, {useHash: true})
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule {
}
