import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountCreationPageComponent } from './account-creation-page.component';

describe('AccountCreationPageComponent', () => {
  let component: AccountCreationPageComponent;
  let fixture: ComponentFixture<AccountCreationPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AccountCreationPageComponent]
    });
    fixture = TestBed.createComponent(AccountCreationPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
