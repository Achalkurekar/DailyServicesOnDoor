import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpNotificationComponent } from './sp-notification.component';

describe('SpNotificationComponent', () => {
  let component: SpNotificationComponent;
  let fixture: ComponentFixture<SpNotificationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpNotificationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpNotificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
