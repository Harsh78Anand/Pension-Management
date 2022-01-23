import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-success',
  templateUrl: './success.component.html',
  styleUrls: ['./success.component.css']
})
export class SuccessComponent implements OnInit {

  constructor(private dataRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.dataRoute.params.subscribe(params => {
      console.log(params);
    })
  }
  myFunction() {
    window.location.href = "/home";
  }
}
