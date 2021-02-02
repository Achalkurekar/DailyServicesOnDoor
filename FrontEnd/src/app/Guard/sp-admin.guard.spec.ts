import { TestBed } from '@angular/core/testing';

import { SpAdminGuard } from './sp-admin.guard';

describe('SpAdminGuard', () => {
  let guard: SpAdminGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(SpAdminGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
