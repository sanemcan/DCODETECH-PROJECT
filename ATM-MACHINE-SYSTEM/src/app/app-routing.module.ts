import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';

const routes: Routes = [{path:'Register',component:RegisterPageComponent},
                        {path:'Login',component:LoginPageComponent}
]; // curely bre=acket dile yacha yat n code 

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
