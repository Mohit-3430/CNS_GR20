<details>
<summary>Task 7</summary>

### RSA
- Select two large prime numbers, p and q.
- n = p x q, where n is called the modulus for encryption and decryption.
- Φ(n) = (P-1)(Q-1) 
- Choose value of **e** such that 1<e<n and gcd(Φ(n), e) = 1;
- calculate d = e <sup>-1</sup> modΦ(n) => e d modΦ(n) = 1
- pubK = {e, n}
- privK = {d, n}
 ##### ENC
 C = M<sup>e</sup>modN
 ##### DEC
 M = C<sup>d</sup>modN

</details>

<details>
  <summary>Task 8</summary>
 
   ### Deffie-Hellman
    
|Alice|Bob|
|:----|:----|
|Public Keys available = P, G|Public Keys available = P, G|
|Private Key Selected = a|Private Key Selected = b|
|Key generated =x = G<sup>a</sup> mod P|Key generated =y = G<sup>b</sup> mod P|
|Exchange of generated keys takes place|
|Key received = y|key received = x|
|Generated Secret Key =k_a = y<sup>a</sup> mod P| Generated Secret Key =k_b = x<sup>b</sup> mod P|
|Algebraically, it can be shown thatk_a = k_b|
|Users now have a symmetric secret key to encrypt|

  
</details>
