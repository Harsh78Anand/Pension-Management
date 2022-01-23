import { ComponentFixture, TestBed,waitForAsync } from '@angular/core/testing';



import { ProcessPensionInputComponent } from './process-pension-input.component';
import { ToastrModule } from 'ngx-toastr';
import { AppModule } from '../app.module';

describe('ProcessPensionInputComponent', () => {
  let component: ProcessPensionInputComponent;
  let fixture: ComponentFixture<ProcessPensionInputComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AppModule],
      declarations: [ ProcessPensionInputComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcessPensionInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it(
    'Aadhaar Number check -valid',
    waitForAsync(() => {
      fixture.whenStable().then(() => {
        let aadhar = component.processForm.controls['aadhaarNumber'];
        expect(aadhar.valid).toBeFalsy();
        aadhar.setValue('123232');
        expect(aadhar.valid).toBeTruthy();
      });
    })
  );
  it(
   'Aadhaar Number check -invalid',
   waitForAsync(() => {
     fixture.whenStable().then(() => {
       let aadhar = component.processForm.controls['aadhaarNumber'];
       aadhar.setValue('');
       expect(aadhar.valid).toBeFalsy();
     });
   })
 );
 it(
  'Pension Amount check -valid',
  waitForAsync(() => {
    fixture.whenStable().then(() => {
      let amt = component.processForm.controls['pensionAmount'];
      amt.setValue('15000');
      expect(amt.valid).toBeTruthy();
    });
  })
);
it(
  'Pension Amount check -invalid',
  waitForAsync(() => {
    fixture.whenStable().then(() => {
      let amt = component.processForm.controls['pensionAmount'];
      amt.setValue('');
      expect(amt.valid).toBeFalsy();
    });
  })
);
it(
  'Bank-Service Charge check -valid',
  waitForAsync(() => {
    fixture.whenStable().then(() => {
      let bsc = component.processForm.controls['bankServiceCharge'];
      bsc.setValue('3');
      expect(bsc.valid).toBeTruthy();
    });
  })
);
it(
  'Bank-Service Charge check -invalid',
  waitForAsync(() => {
    fixture.whenStable().then(() => {
      let bsc = component.processForm.controls['bankServiceCharge'];
      bsc.setValue('');
      expect(bsc.valid).toBeFalsy();
    });
  })
);
it(
  'form  check -valid',
  waitForAsync(() => {
    fixture.whenStable().then(() => {
       let aadhar = component.processForm.controls['aadhaarNumber'];
       aadhar.setValue('123232');
      let amt = component.processForm.controls['pensionAmount'];
      amt.setValue('15000');
      let bsc= component.processForm.controls['bankServiceCharge'];
      bsc.setValue('2');
      expect(component.processForm.valid).toBeTruthy();
    });
  })
);

it(
  'form  check -invalid',
  waitForAsync(() => {
    fixture.whenStable().then(() => {
       let aadhar = component.processForm.controls['aadhaarNumber'];
       aadhar.setValue('');
      let amt = component.processForm.controls['pensionAmount'];
      amt.setValue('');
      let bsc= component.processForm.controls['bankServiceCharge'];
      bsc.setValue('');
      expect(component.processForm.valid).toBeFalsy();
    });
  })
);
it(
  'form  check -invalid',
  waitForAsync(() => {
    fixture.whenStable().then(() => {
       let aadhar = component.processForm.controls['aadhaarNumber'];
       aadhar.setValue('123232');
      let amt = component.processForm.controls['pensionAmount'];
      amt.setValue('');
      let bsc= component.processForm.controls['bankServiceCharge'];
      bsc.setValue('');
      expect(component.processForm.valid).toBeFalsy();
    });
  })
);
it(
  'form  check -invalid',
  waitForAsync(() => {
    fixture.whenStable().then(() => {
       let aadhar = component.processForm.controls['aadhaarNumber'];
       aadhar.setValue('123232');
      let amt = component.processForm.controls['pensionAmount'];
      amt.setValue('15000');
      let bsc= component.processForm.controls['bankServiceCharge'];
      bsc.setValue('');
      expect(component.processForm.valid).toBeFalsy();
    });
  })
);
});
