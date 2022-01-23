import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from "@angular/router/testing";
import { HttpClientTestingModule } from "@angular/common/http/testing";

import { PensionService } from './pension.service';

describe('PensionService', () => {
  let service: PensionService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [RouterTestingModule, HttpClientTestingModule],
    });
    service = TestBed.inject(PensionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
