import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEmpSbComponent } from './add-emp-sb.component';

describe('AddEmpSbComponent', () => {
  let component: AddEmpSbComponent;
  let fixture: ComponentFixture<AddEmpSbComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddEmpSbComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddEmpSbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
