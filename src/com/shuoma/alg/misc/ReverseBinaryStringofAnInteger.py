def rev(n):
    print bin(n)
    n = ((n & 0x55555555) << 1) | ((n & 0xAAAAAAAA) >> 1)
    print bin(n)
    n = ((n & 0x33333333) << 2) | ((n & 0xCCCCCCCC) >> 2)
    print bin(n)
    n = ((n & 0x0F0F0F0F) << 4) | ((n & 0xF0F0F0) >> 4)
    print bin(n)
    n = ((n & 0x00FF00FF) << 8) | ((n & 0xFF00FF00) >> 8)
    print bin(n)
    n = (n << 16) | (n >> 16)
    print bin(n)

rev(10)
