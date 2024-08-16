import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateEmpSbComponent } from './update-emp-sb.component';

describe('UpdateEmpSbComponent', () => {
  let component: UpdateEmpSbComponent;
  let fixture: ComponentFixture<UpdateEmpSbComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateEmpSbComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateEmpSbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
