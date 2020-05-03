import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DebitcarddetailsComponent } from './debitcarddetails.component';

describe('DebitcarddetailsComponent', () => {
  let component: DebitcarddetailsComponent;
  let fixture: ComponentFixture<DebitcarddetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DebitcarddetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DebitcarddetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
