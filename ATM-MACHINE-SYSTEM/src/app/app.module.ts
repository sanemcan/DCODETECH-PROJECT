import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { WelcomePageHeaderComponent } from './welcome-page-header/welcome-page-header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';

import { ReactiveFormsModule } from '@angular/forms';
import { AccountCreationPageComponent } from './account-creation-page/account-creation-page.component';
import { TransactionHistoryComponent } from './transaction-history/transaction-history.component';
import { PinChangeComponent } from './pin-change/pin-change.component';
import { ChequebookRequestComponent } from './chequebook-request/chequebook-request.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomePageComponent,
    WelcomePageHeaderComponent,
    FooterComponent,
    LoginPageComponent,
    UserDashboardComponent,
   
    AccountCreationPageComponent,
    TransactionHistoryComponent,
    PinChangeComponent,
    ChequebookRequestComponent,
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
