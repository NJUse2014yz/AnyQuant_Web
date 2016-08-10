package tool;

import java.util.List;

public class LinearRegressionTool{
	/**
	*一元线性回归分析
	*@param x[n] 存放自变量x的n个取值
	*@param y[n] 存放与自变量x的n个取值相对应的随机变量y的观察值
	*@param n 观察点数
	*@param a[2] a(0)返回回归系数b，a(1)返回回归系数a
	*@param dt[6] dt(0)返回偏差平方和，dt(1)返回平均标准偏差s，dt(2)返回回归平方和p，dt(3)返回最大偏差umax，dt(4)返回最小偏差umin，dt(5)返回偏差平均值u
	*/
	public static void SPT1(List<Double> x,List<Double> y,int n,double[] a,double[] dt)
	{
		int i;
		double xx,yy,e,f,q,u,p,umax,umin,s;
		xx=0.0;
		yy=0.0;
		for(i=0;i<n;i++)
		{
			xx=xx+x.get(i)/n;
			yy=yy+y.get(i)/n;
		}
		e=0.0;
		f=0.0;
		for(i=0;i<n;i++)
		{
			q=x.get(i)-xx;
			e=e+q*q;
			f=f+q*(y.get(i)-yy);
		}
		a[1]=f/e;
		a[0]=yy-a[1]*xx;
		q=0.0;
		u=0.0;
		p=0.0;
		umax=0.0;
		umin=1.0e+30;
		for(i=0;i<n;i++)
		{
			s=a[1]*x.get(i)+a[0];
			q=q+(y.get(i)-s)*(y.get(i)-s);
			p=p+(s-yy)*(s-yy);
			e=Math.abs(y.get(i)-s);
			if(e>umax)
				umax=e;
			if(e<umin)
				umin=e;
			u=u+e/n;
		}
		dt[1]=Math.sqrt(q/n);
		dt[0]=q;
		dt[2]=p;
		dt[3]=umax;
		dt[4]=umin;
		dt[5]=u;
	}
	/**
	*多元线性回归分析
	*@param x[m][n] 每一列存放m个自变量的观察值
	*@param y[n] 存放随机变量y的n个观察值
	*@param m 自变量的个数
	*@param n 观察数据的组数
	*@param a 返回回归系数a0,...,am
	*@param dt[4] dt[0]偏差平方和，dt[1]平均标准偏差s，dt[2]返回复相关系数r，dt[3]返回回归平方和u
	*@param v[m] 返回m个自变量的偏相关系数
	*/
	public static void SQT2(double[][] x,double[] y,int m,int n,double[] a,double[] dt,double[] v)
	{
		int i,j,k,mm;
		double q,e,u,p,yy,s,r,pp;
		double[]b=new double[(m+1)*(m+1)];
		mm=m+1;
		b[mm*mm-1]=n;
		for(j=0;j<=m-1;j++)
		{
			p=0.0;
			for(i=0;i<=n-1;i++)
			{
				p=p+x[j][i];
				b[m*mm+j]=p;
				b[j*mm+m]=p;
			}
		}
		for(i=0;i<=m-1;i++)
		{
			for(j=0;j<=m-1;j++)
			{
				p=0.0;
				for(k=0;k<=n-1;k++)
				{
					p=p+x[i][k]*x[j][k];
				}
				b[j*mm+i]=p;
				b[i*mm+j]=p;
			}
		}
		a[m]=0.0;
		for(i=0;i<=n-1;i++)
		{
			a[m]=a[m]+y[i];
		}
		for(i=0;i<=m-1;i++)
		{
			a[i]=0.0;
			for(j=0;j<=n-1;j++)
			{
				a[i]=a[i]+x[i][j]*y[j];
			}
		}
		chlk(b,mm,1,a);
		yy=0.0;
		for(i=0;i<=n-1;i++)
		{
			yy=yy+y[i]/n;
		}
		q=0.0;
		e=0.0;
		u=0.0;
		for(i=0;i<=n-1;i++)
		{
			p=a[m];
			for(j=0;j<=m-1;j++)
			{
				p=p+a[j]*x[j][i];
			}
			q=q+(y[i]-p)*(y[i]-p);
			e=e+(y[i]-yy)*(y[i]-yy);
			u=u+(yy-p)*(yy-p);
		}
		s=Math.sqrt(q/n);
		r=Math.sqrt(1.0-q/e);
		for(j=0;j<=m-1;j++)
		{
			p=0.0;
			for(i=0;i<=n-1;i++)
			{
				pp=a[m];
				for(k=0;k<=m-1;k++)
				{
					if(k!=j)
					{
						pp=pp+a[k]*x[k][i];
					}
				}
				p=p+(y[i]-pp)*(y[i]-pp);
			}
			v[j]=Math.sqrt(1.0-q/p);
		}
		dt[0]=q;
		dt[1]=s;
		dt[2]=r;
		dt[3]=u;	
	}
	
	private static int chlk(double[] a,int n,int m,double[] d)
	{
		int i,j,k,u,v;
		if((a[0]+1.0==1.0)||(a[0]<0.0))
		{
			System.out.println("fail\n");
			return(-2);
		}
		a[0]=Math.sqrt(a[0]);
		for(j=1;j<=n-1;j++)
		{
			a[j]=a[j]/a[0];
		}
		for(i=1;i<=n-1;i++)
		{
			u=i*n+i;
			for(j=1;j<=i;j++)
			{
				v=(j-1)*n+i;
				a[u]=a[u]-a[v]*a[v];
			}
			if((a[u]+1.0==1.0)||(a[u]<0.0))
			{
				System.out.println("fail\n");
				return(-2);
			}
			a[u]=Math.sqrt(a[u]);
			if(i!=(n-1))
			{
				for(j=i+1;j<=n-1;j++)
				{
					v=i*n+j;
					for(k=1;k<=i;k++)
					{
						a[v]=a[v]-a[(k-1)*n+i]*a[(k-1)*n+j];
					}
					a[v]=a[v]/a[u];
				}
			}
		}
		for(j=0;j<=m-1;j++)
		{
			d[j]=d[j]/a[0];
			for(i=1;i<=n-1;i++)
			{
				u=i*n+i;
				v=i*m+j;
				for(k=1;k<=i;k++)
				{
					d[v]=d[v]-a[(k-1)*n+i]*d[(k-1)*m+j];
				}
				d[v]=d[v]/a[u];
			}
		}
		for(j=0;j<=m-1;j++)
		{
			u=(n-1)*m+j;
			d[u]=d[u]/a[n*n-1];
			for(k=n-1;k>=1;k--)
			{
				u=(k-1)*m+j;
				for(i=k;i<=n-1;i++)
				{
					v=(k-1)*n+i;
					d[u]=d[u]-a[v]*d[i*m+j];
				}
				v=(k-1)*n+k-1;
				d[u]=d[u]/a[v];
			}
		}
		return 2;
	}
	public static void main(String[] args)
	{
		//y=a0*x0+a1*x1+a2
		double[][] x={{-Math.PI/2,-Math.PI/3,-Math.PI/4,-Math.PI/6},//0,Math.PI/6,1/5),Math.PI/6,1/5),Math.PI/6,1/5),-Math.PI/2,1/5),-Math.PI/4,1/5)},
				{Math.PI/2,Math.PI/3,Math.PI/4,Math.PI/6}};//0,-Math.PI/6,1/3),Math.PI/4,1/3),Math.PI/2,1/3),-Math.PI/6,1/3),-Math.PI/6,1/3)}};
		double[] y={-Math.PI/2,-Math.PI/3,-Math.PI/4,-Math.PI/6};//0,0,0,0,0,0};
		int m=2;
		int n=4;
		double[] a=new double[m+1];
		double[] dt=new double[4];
		double[] v=new double[m];
		LinearRegressionTool.SQT2(x, y, m, n, a, dt, v);
	}
}