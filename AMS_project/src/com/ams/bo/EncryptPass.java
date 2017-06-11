package com.ams.bo;

public class EncryptPass {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String q="admin";  //Enter the password to be encrypted
				char[] a=q.toCharArray();
				char[] b=new char[a.length];
				char[] r=new char[a.length];
			    int i;
			    char secret[] = { 22, 53, 44, 71, 66, 177, 253, 122, 4, 14, 39, 420 };
			    System.out.println("Password Entered : "+new String(a));
			    for(i = 0; i < b.length; i++)
			        {b[i]=a[i];
			    	b[i] ^= secret[i];
			        }
			
			   System.out.println("Encrypted Password : "+new String(b));
			   
			   //(Following code for decryption)
//			    for(i = 0; i < r.length; i++)
//			        {r[i]=b[i];
//			    	r[i] ^= secret[i];
//			        }
//			    
//			    System.out.println(r);
			}


	}

