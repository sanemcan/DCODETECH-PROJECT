import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { AccountCreationPageComponent } from './account-creation-page/account-creation-page.component';
import { TransactionHistoryComponent } from './transaction-history/transaction-history.component';
import { MoneyTransferFormComponent } from './money-transfer-page/money-transfer-page.component';
import { ChangePhoneNumberPageComponent } from './change-phone-number-page/change-phone-number-page.component';

const routes: Routes = [{path:'Register',component:RegisterPageComponent},
                        {path:'Login',component:LoginPageComponent},
                        {path: 'Welcome' , component: WelcomePageComponent},
                        {path: 'Account' , component: AccountCreationPageComponent},
                        {path: 'Transaction' , component: TransactionHistoryComponent},
                        {path: 'Moneytransfer' , component: MoneyTransferFormComponent},
                        {path: 'Changephonenumber' , component: ChangePhoneNumberPageComponent}
]; // curely bre=acket dile yacha yat n code 

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
