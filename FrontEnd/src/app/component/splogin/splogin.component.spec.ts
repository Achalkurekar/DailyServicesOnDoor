import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SploginComponent } from './splogin.component';

describe('SploginComponent', () => {
  let component: SploginComponent;
  let fixture: ComponentFixture<SploginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SploginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SploginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
