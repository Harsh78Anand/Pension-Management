
import { ComponentFixture, TestBed,waitForAsync } from '@angular/core/testing';


import {  ToastrService } from 'ngx-toastr';
import { AppModule } from '../app.module';



import { LoginComponent } from './login.component';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AppModule],
      declarations: [ LoginComponent ],
      providers: [
        {provide: ToastrService, useClass: ToastrService}
      ]
      
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();

   
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it(
    'userName check -valid',
    waitForAsync(() => {
      fixture.whenStable().then(() => {
        let useId = component.loginForm.controls['userName'];
        expect(useId.valid).toBeFalsy();
        useId.setValue('mahima');
        expect(useId.valid).toBeTruthy();
      });
    })
  );
  it(
    'userName check -invalid',
    waitForAsync(() => {
      fixture.whenStable().then(() => {
        let useId = component.loginForm.controls['userName'];
        useId.setValue('');
        expect(useId.valid).toBeFalsy();
      });
    })
  );
   it(
     'password check -invalid',
     waitForAsync(() => {
       fixture.whenStable().then(() => {
         let pass = component.loginForm.controls['password'];
         pass.setValue('');
         expect(pass.valid).toBeFalsy();
       });
     })
   );
    it(
      'password check -valid',
      waitForAsync(() => {
        fixture.whenStable().then(() => {
          let pass = component.loginForm.controls['password'];
          pass.setValue('abc1');
          expect(pass.valid).toBeTruthy();
        });
      })
    );
     it(
       'form  check -valid',
       waitForAsync(() => {
         fixture.whenStable().then(() => {
            let useId = component.loginForm.controls['userName'];
            useId.setValue('mahima');
           let pass = component.loginForm.controls['password'];
           pass.setValue('abc1');
           expect(component.loginForm.valid).toBeTruthy();
         });
       })
     );
     it(
       'form  check -invalid for no username',
       waitForAsync(() => {
         fixture.whenStable().then(() => {
           let useId = component.loginForm.controls['userName'];
           useId.setValue('');
           let pass = component.loginForm.controls['password'];
           pass.setValue('abc1');
           expect(component.loginForm.valid).toBeFalsy();
         });
       })
     );
     it(
       'form  check -invalid for no password',
       waitForAsync(() => {
         fixture.whenStable().then(() => {
           let useId = component.loginForm.controls['userName'];
           useId.setValue('mahima');
           
           expect(component.loginForm.valid).toBeFalsy();
         });
       })
     );
});
