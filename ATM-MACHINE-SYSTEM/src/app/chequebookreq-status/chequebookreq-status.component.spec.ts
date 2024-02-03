import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChequebookreqStatusComponent } from './chequebookreq-status.component';

describe('ChequebookreqStatusComponent', () => {
  let component: ChequebookreqStatusComponent;
  let fixture: ComponentFixture<ChequebookreqStatusComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ChequebookreqStatusComponent]
    });
    fixture = TestBed.createComponent(ChequebookreqStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
