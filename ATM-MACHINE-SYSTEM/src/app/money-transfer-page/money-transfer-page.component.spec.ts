import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoneyTransferFormComponent } from './money-transfer-page.component';

describe('MoneyTransferPageComponent', () => {
  let component: MoneyTransferFormComponent;
  let fixture: ComponentFixture<MoneyTransferFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MoneyTransferFormComponent]
    });
    fixture = TestBed.createComponent(MoneyTransferFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
