import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HoteFormComponent } from './hotel-form.component';

describe('HoteFormComponent', () => {
  let component: HoteFormComponent;
  let fixture: ComponentFixture<HoteFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HoteFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HoteFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
