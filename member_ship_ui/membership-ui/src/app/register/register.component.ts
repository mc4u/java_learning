import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {Member} from '../domain/member';
import {ShareService} from '../share/share.service';
import {error} from 'protractor';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;

  constructor(private fb: FormBuilder,
              private router: Router,
              private shareService: ShareService) {
    this.registerForm = fb.group({
      name: ['', [Validators.required]],
      emailId: ['abc@gmail.com', [Validators.required]],
      password: ['', [Validators.required]],
      orgId: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {
  }

  registration = () => {
    const val = this.registerForm.value;
    console.log('Registration Value ', val);
    const member = new Member(val.name, val.emailId, val.password, val.orgId);
    // call the API to register the member
    this.shareService.registration(member).subscribe(response => {
      console.log(response);
    });
  }

}
