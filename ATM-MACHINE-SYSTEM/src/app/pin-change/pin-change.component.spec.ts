import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PinChangeComponent } from './pin-change.component';

describe('PinChangeComponent', () => {
  let component: PinChangeComponent;
  let fixture: ComponentFixture<PinChangeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PinChangeComponent]
    });
    fixture = TestBed.createComponent(PinChangeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
