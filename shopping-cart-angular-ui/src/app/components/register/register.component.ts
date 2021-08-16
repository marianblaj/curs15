import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {RegisterService} from "../../services/register.service";
import {UserResitrationDetailsDto} from "../../models/userResitrationDetailsDto";
import {MatDialog} from '@angular/material/dialog';


/**
 *
 * @param form
 */

function passwordsMatchValidator(form) {
  const password = form.get('password');
  const confirmPassword = form.get('confirmPassword');

  if (password.value !== confirmPassword.value) {
    confirmPassword.setErrors({passwordsMatch: true});
  } else {
    confirmPassword.setErrors(null);
  }

  return null;
}

/**
 * If the data is valid return null else return an object
 */
function symbolValidator(control) {
  if (control.hasError('required')) {
    return null;
  }
  if (control.hasError('minlength')) {
    return null;
  }

  if (control.value.indexOf('@') > -1) {
    return null;
  } else {
    return {symbol: true};
  }
}

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  userRegistrationDto: UserResitrationDetailsDto;
  showMyMessage = false;

  constructor(private builder: FormBuilder,
              private registerService: RegisterService,
              public dialog: MatDialog) {
  }

  ngOnInit() {
    this.buildForm();
  }

  buildForm() {
    this.registerForm = this.builder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, symbolValidator, Validators.minLength(4)]],
      confirmPassword: ''
    }, {
      validators: passwordsMatchValidator
    });

  }

  buildUserRegistrationDto() {
    this.userRegistrationDto = new UserResitrationDetailsDto(
      this.registerForm.value.firstName,
      this.registerForm.value.lastName,
      this.registerForm.value.email,
      this.registerForm.value.password
    );
  }

  register() {
    this.buildUserRegistrationDto();
    this.registerService.addUserRegistration(this.userRegistrationDto).subscribe();
  }

  openDialog() {
    this.dialog.open(emailConfirmationTemplate);
  }
}
@Component({
  selector: 'emailConfirmationTemplate',
  templateUrl: 'emailConfirmationTemplate.html',
})
export class emailConfirmationTemplate {}
