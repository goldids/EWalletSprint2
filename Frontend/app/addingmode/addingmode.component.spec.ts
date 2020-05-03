import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddingmodeComponent } from './addingmode.component';

describe('AddingmodeComponent', () => {
  let component: AddingmodeComponent;
  let fixture: ComponentFixture<AddingmodeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddingmodeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddingmodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
