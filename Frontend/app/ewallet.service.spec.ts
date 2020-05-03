import { TestBed } from '@angular/core/testing';

import { EwalletService } from './ewallet.service';

describe('EwalletService', () => {
  let service: EwalletService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EwalletService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
