import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpServiceByIdComponent } from './sp-service-by-id.component';

describe('SpServiceByIdComponent', () => {
  let component: SpServiceByIdComponent;
  let fixture: ComponentFixture<SpServiceByIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpServiceByIdComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpServiceByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
