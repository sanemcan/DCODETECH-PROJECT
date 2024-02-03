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
import { ChequebookreqStatusComponent } from './chequebookreq-status/chequebookreq-status.component';
import { ChequebookreqDataComponent } from './chequebookreq-data/chequebookreq-data.component';

const routes: Routes = [
  { path: 'welcome', component: WelcomePageComponent },
  { path: 'account', component: AccountCreationPageComponent },
  { path: 'transaction', component: TransactionHistoryComponent },
  { path: 'dashboard', component: UserDashboardComponent },
  { path: 'pinchange', component: PinChangeComponent },
  { path: 'chequebookrequest', component: ChequebookRequestComponent },
  { path: 'Register', component: RegisterPageComponent },
  { path: 'Login', component: LoginPageComponent },
  { path: 'Moneytransfer', component: MoneyTransferFormComponent },
  { path: 'Changephonenumber', component: ChangePhoneNumberPageComponent },
  { path: 'Chequebookreqtstatus', component: ChequebookreqStatusComponent},
  { path: 'Chequebookreqtdata', component: ChequebookreqDataComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
