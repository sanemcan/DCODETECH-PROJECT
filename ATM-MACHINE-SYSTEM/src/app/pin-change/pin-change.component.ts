import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-pin-change',
  templateUrl: './pin-change.component.html',
  styleUrls: ['./pin-change.component.css']
})
export class PinChangeComponent implements OnInit {
  pinform!: FormGroup;
  constructor(private fd: FormBuilder) { }

  ngOnInit(): void {
    this.pinChangeForm();
  }

get changepinbtn():string{return this.pinform.valid ? '#2d6a4f' : '#b7e4c7';}

  pinChangeForm(): void {
    this.pinform = this.fd.group({
      accountnumber: ['', Validators.required],
      cardnumber: ['', Validators.required],
      currentpin: ['', [Validators.required, Validators.minLength(4)]],
      newpin: ['', [Validators.required, Validators.minLength(4)]],
      expdate: ['', Validators.required]
    })
  }
}
