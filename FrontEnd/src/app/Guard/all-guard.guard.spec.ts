import { TestBed } from '@angular/core/testing';

import { AllGuardGuard } from './all-guard.guard';

describe('AllGuardGuard', () => {
  let guard: AllGuardGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(AllGuardGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
