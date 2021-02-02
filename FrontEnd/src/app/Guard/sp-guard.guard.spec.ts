import { TestBed } from '@angular/core/testing';

import { SpGuardGuard } from './sp-guard.guard';

describe('SpGuardGuard', () => {
  let guard: SpGuardGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(SpGuardGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
