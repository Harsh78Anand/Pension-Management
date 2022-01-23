
import { ComponentFixture, TestBed ,waitForAsync} from '@angular/core/testing';

import {  ToastrService } from 'ngx-toastr';
import { AppModule } from '../app.module';



import { PensionerInputComponent } from './pensioner-input.component';

describe('PensionerInputComponent', () => {
  let component: PensionerInputComponent;
  let fixture: ComponentFixture<PensionerInputComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        AppModule
        ],
      declarations: [ PensionerInputComponent ],
      providers: [
        {provide: ToastrService, useClass: ToastrService}
      ]
      
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PensionerInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it(
    'Name check -valid',
    waitForAsync(() => {
      fixture.whenStable().then(() => {
        let nme = component.pensionerForm.controls['name'];
        expect(nme.valid).toBeFalsy();
        nme.setValue('John');
        expect(nme.valid).toBeTruthy();
      });
    })
  );
  it(
    'Name check -invalid',
    waitForAsync(() => {
      fixture.whenStable().then(() => {
        let nme = component.pensionerForm.controls['name'];
        nme.setValue('');
        expect(nme.valid).toBeFalsy();
      });
    })
  );
  it(
    'Aadhaar Number check -valid',
    waitForAsync(() => {
      fixture.whenStable().then(() => {
        let aadhar = component.pensionerForm.controls['aadhaarNumber'];
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
       let aadhar = component.pensionerForm.controls['aadhaarNumber'];
       aadhar.setValue('');
       expect(aadhar.valid).toBeFalsy();
     });
   })
 );
 it(
  'PAN check -valid',
  waitForAsync(() => {
    fixture.whenStable().then(() => {
      let pan = component.pensionerForm.controls['pan'];
      expect(pan.valid).toBeFalsy();
      pan.setValue('xyz2323');
      expect(pan.valid).toBeTruthy();
    });
  })
);
it(
 'PAN check -invalid',
 waitForAsync(() => {
   fixture.whenStable().then(() => {
     let pan = component.pensionerForm.controls['pan'];
     pan.setValue('');
     expect(pan.valid).toBeFalsy();
   });
 })
);

it(
  'Date Of Birth check -valid',
  waitForAsync(() => {
    fixture.whenStable().then(() => {
      let dob = component.pensionerForm.controls['dateOfBirth'];
      
      dob.setValue('29-07-2021');
      expect(dob.valid).toBeTruthy();
    });
  })
);
it(
 'Date Of Birth check -invalid',
 waitForAsync(() => {
   fixture.whenStable().then(() => {
     let dob = component.pensionerForm.controls['dateOfBirth'];
     dob.setValue('');
     expect(dob.valid).toBeFalsy();
   });
 })
);
it(
  'form  check -valid',
  waitForAsync(() => {
    fixture.whenStable().then(() => {
       let nme = component.pensionerForm.controls['name'];
       nme.setValue('mahima');
      let aadhar = component.pensionerForm.controls['aadhaarNumber'];
      aadhar.setValue('123232');
      let pan = component.pensionerForm.controls['pan'];
      pan.setValue('xyz2323');
      let dob = component.pensionerForm.controls['dateOfBirth'];
      dob.setValue('19-07-2021');
      expect(component.pensionerForm.valid).toBeTruthy();
    });
  })
);
it(
  'form  check -invalid',
  waitForAsync(() => {
    fixture.whenStable().then(() => {
       let nme = component.pensionerForm.controls['name'];
       nme.setValue('');
      let aadhar = component.pensionerForm.controls['aadhaarNumber'];
      aadhar.setValue('');
      let pan = component.pensionerForm.controls['pan'];
      pan.setValue('');
      let dob = component.pensionerForm.controls['dateOfBirth'];
      dob.setValue('');
      expect(component.pensionerForm.valid).toBeFalsy();
    });
  })
);

});
