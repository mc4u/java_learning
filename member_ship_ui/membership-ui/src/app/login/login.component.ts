import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ShareService} from '../share/share.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loader = false;
  constructor(private fb: FormBuilder,
              private router: Router,
              private route: ActivatedRoute,
              private shareService: ShareService) {
    this.loginForm = fb.group({
      emailId: ['', [Validators.required]],
      password: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {
  }

  login = () => {
   const val = this.loginForm.value;
   console.log('Form value ', val);
   this.loader = true;
   this.shareService.login(val.emailId, val.password)
     .subscribe(res => {
        console.log('Login ', res);
        this.loader = false;
        this.router.navigate(['dashbord'], {relativeTo: this.route.parent});
    });
  }

}
