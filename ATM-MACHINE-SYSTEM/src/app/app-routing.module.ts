import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { AccountCreationPageComponent } from './account-creation-page/account-creation-page.component';
import { TransactionHistoryComponent } from './transaction-history/transaction-history.component';


const routes: Routes = [
  {path: 'welcome' , component: WelcomePageComponent},
  {path: 'account' , component: AccountCreationPageComponent},
  {path: 'transaction' , component: TransactionHistoryComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
