KFLOW - InputDATA - NACA0012 Airfoil
===============================================================================
KFLOW CONDITION
-------------------------------------------------------------------------------
rho_inf	  t_inf	   p_inf	t_wall	pran	prat	gamma
1.24d0    288.0    1.01325d5    288.0	0.72	0.9	1.398
turbulence : viscosity	intensity	length	Comp.correction(0/1)
             0.009	0.072	        2.0d-5	0
===============================================================================
FLUX FUNCTION DEFINITION
-------------------------------------------------------------------------------
f_func	f_order	tol_lm	limiter	entropy_fix	delta
1	2	3.0	6	3	        0.0005
icent_disc	icent_order	ivis_order	ifilter_method
1	        6	        2	        2
ifilter_type	iLF	iYacm	fka1	fka2	iswt1	iswt2	r_c
1	2	0	1.0	1.0	1	2	0.3
periodicity	homogeneous
F	F	F	F	F	F
===============================================================================
TIME INTEGRATION
-------------------------------------------------------------------------------
cfl_no	  unst_coef	local	dt_uns	t_max	cut_time
2.5       1.0	        2	0.025	100.0	60.0
it_method	istage	delta_imp	xvel_init
1	3	0.1	-1.0
===============================================================================
CONVERGENCE & WRITING
-------------------------------------------------------------------------------
max_iter    rms_tol      restart     his_step       write_step      iuns_step
50000       1.0d-15      0           50	            10000           100
iverbose    writeform    readform    KFLOW_write    MetaData_write
1           2            1           1              0
===============================================================================
REFERENCE DATA
-------------------------------------------------------------------------------
scale_ref   surf_ref   chord_ref   span_ref   jgravity   move
1.0         1.0        1.0         1.0        0          0
center(x,y,z)
0.25 0.0 0.0
alpha0(x,y,z)
0.0 0.0 0.0
alpha
0.0 0.0 0.0
vel0
0.0 0.0 0.0
vel
0.0 0.0 0.0
omega
0.0 0.0 0.0
freq
0.0 0.0 0.0
spin_rate
0.0
LESpoint
1
0.0 0.0 0.0
