import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListEmpSbComponent } from './list-emp-sb.component';

describe('ListEmpSbComponent', () => {
  let component: ListEmpSbComponent;
  let fixture: ComponentFixture<ListEmpSbComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListEmpSbComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListEmpSbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
