import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { WelcomePageHeaderComponent } from './welcome-page-header/welcome-page-header.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AccountCreationPageComponent } from './account-creation-page/account-creation-page.component';
import { TransactionHistoryComponent } from './transaction-history/transaction-history.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomePageComponent,
    WelcomePageHeaderComponent,
    AccountCreationPageComponent,
    TransactionHistoryComponent,
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
