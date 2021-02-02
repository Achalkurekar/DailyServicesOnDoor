import { TestBed } from '@angular/core/testing';

import { UAGuardGuard } from './uaguard.guard';

describe('UAGuardGuard', () => {
  let guard: UAGuardGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(UAGuardGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
