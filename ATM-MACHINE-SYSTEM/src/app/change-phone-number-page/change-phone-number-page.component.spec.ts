import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangePhoneNumberPageComponent } from './change-phone-number-page.component';

describe('ChangePhoneNumberPageComponent', () => {
  let component: ChangePhoneNumberPageComponent;
  let fixture: ComponentFixture<ChangePhoneNumberPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ChangePhoneNumberPageComponent]
    });
    fixture = TestBed.createComponent(ChangePhoneNumberPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
