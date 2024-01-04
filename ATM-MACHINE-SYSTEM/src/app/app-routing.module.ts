import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { AccountCreationPageComponent } from './account-creation-page/account-creation-page.component';
import { TransactionHistoryComponent } from './transaction-history/transaction-history.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { FooterComponent } from './footer/footer.component';
import { PinChangeComponent } from './pin-change/pin-change.component';
import { ChequebookRequestComponent } from './chequebook-request/chequebook-request.component';


import { MoneyTransferFormComponent } from './money-transfer-page/money-transfer-page.component';
import { ChangePhoneNumberPageComponent } from './change-phone-number-page/change-phone-number-page.component';
import { WelcomepagefinalComponent } from './welcomepagefinal/welcomepagefinal.component';
import { AuthGuard } from './AuthGuard';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Routes = [
  { path: '', component: WelcomepagefinalComponent }, //change
  { path: 'welcome', component: WelcomepagefinalComponent }, 
  { path: 'account', component: AccountCreationPageComponent, canActivate: [AuthGuard] },
  { path: 'transaction', component: TransactionHistoryComponent, canActivate: [AuthGuard] },
  { path: 'dashboard', component: UserDashboardComponent, canActivate: [AuthGuard] },
  { path: 'pinchange', component: PinChangeComponent, canActivate: [AuthGuard] },
  { path: 'chequebookrequest', component: ChequebookRequestComponent, canActivate: [AuthGuard] },
  { path: 'register', component: RegisterPageComponent },
  { path: 'login', component: LoginPageComponent },     //change
  { path: 'Moneytransfer', component: MoneyTransferFormComponent, canActivate: [AuthGuard] },
  { path: 'Changephonenumber', component: ChangePhoneNumberPageComponent, canActivate: [AuthGuard] },
  { path: '**', component: PageNotFoundComponent}

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
