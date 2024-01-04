import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WelcomepagefinalComponent } from './welcomepagefinal.component';

describe('WelcomepagefinalComponent', () => {
  let component: WelcomepagefinalComponent;
  let fixture: ComponentFixture<WelcomepagefinalComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WelcomepagefinalComponent]
    });
    fixture = TestBed.createComponent(WelcomepagefinalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
