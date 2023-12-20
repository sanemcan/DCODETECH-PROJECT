import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
// import { WelcomePageComponent } from './welcome-page/welcome-page.component';
// import { WelcomePageHeaderComponent } from './welcome-page-header/welcome-page-header.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { WelcomePageHeaderComponent } from './welcome-page-header/welcome-page-header.component';

import { AccountCreationPageComponent } from './account-creation-page/account-creation-page.component';
import { TransactionHistoryComponent } from './transaction-history/transaction-history.component';
import { MoneyTransferFormComponent } from './money-transfer-page/money-transfer-page.component';
import { ChangePhoneNumberPageComponent } from './change-phone-number-page/change-phone-number-page.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomePageComponent,
    WelcomePageHeaderComponent,
    LoginPageComponent,
    RegisterPageComponent,
    AccountCreationPageComponent,
    TransactionHistoryComponent,
    MoneyTransferFormComponent,
    ChangePhoneNumberPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
    
  ],
  
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
