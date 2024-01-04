import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
// import { WelcomePageComponent } from './welcome-page/welcome-page.component';
// import { WelcomePageHeaderComponent } from './welcome-page-header/welcome-page-header.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { WelcomePageHeaderComponent } from './welcome-page-header/welcome-page-header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';

import { PinChangeComponent } from './pin-change/pin-change.component';
import { ChequebookRequestComponent } from './chequebook-request/chequebook-request.component';

import { AccountCreationPageComponent } from './account-creation-page/account-creation-page.component';
import { TransactionHistoryComponent } from './transaction-history/transaction-history.component';
import { MoneyTransferFormComponent } from './money-transfer-page/money-transfer-page.component';
import { ChangePhoneNumberPageComponent } from './change-phone-number-page/change-phone-number-page.component';
import { WelcomepagefinalComponent } from './welcomepagefinal/welcomepagefinal.component';
import { ProfilecardComponent } from './profilecard/profilecard.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { HeaderComponent } from './header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomePageComponent,
    WelcomePageHeaderComponent,
    FooterComponent,
    UserDashboardComponent,
   
    AccountCreationPageComponent,
    TransactionHistoryComponent,
    PinChangeComponent,
    ChequebookRequestComponent,
    LoginPageComponent,
    RegisterPageComponent,
    MoneyTransferFormComponent,
    ChangePhoneNumberPageComponent,
    WelcomepagefinalComponent,
    ProfilecardComponent,
    PageNotFoundComponent,
    HeaderComponent,
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
