import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from "@angular/router/testing";
import { HttpClientTestingModule } from "@angular/common/http/testing";

import { PensionDetailComponent } from './pension-detail.component';
import { variable } from '@angular/compiler/src/output/output_ast';

describe('PensionDetailComponent', () => {
  let component: PensionDetailComponent;
  let fixture: ComponentFixture<PensionDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RouterTestingModule, HttpClientTestingModule],
      declarations: [ PensionDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PensionDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();

  });

  it('should create', () => {
    
    expect(component).toBeTruthy();
  });
  
 
});
