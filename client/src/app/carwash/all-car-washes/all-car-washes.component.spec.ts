import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllCarWashesComponent } from './all-car-washes.component';

describe('AllCarWashesComponent', () => {
  let component: AllCarWashesComponent;
  let fixture: ComponentFixture<AllCarWashesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllCarWashesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllCarWashesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
