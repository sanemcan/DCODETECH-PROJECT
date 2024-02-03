import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChequebookreqDataComponent } from './chequebookreq-data.component';

describe('ChequebookreqDataComponent', () => {
  let component: ChequebookreqDataComponent;
  let fixture: ComponentFixture<ChequebookreqDataComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ChequebookreqDataComponent]
    });
    fixture = TestBed.createComponent(ChequebookreqDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
